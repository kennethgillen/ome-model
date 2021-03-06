# #%L
# Bio-Formats C++ libraries (cmake build infrastructure)
# %%
# Copyright © 2006 - 2016 Open Microscopy Environment:
#   - Massachusetts Institute of Technology
#   - National Institutes of Health
#   - University of Dundee
#   - Board of Regents of the University of Wisconsin-Madison
#   - Glencoe Software, Inc.
# %%
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
# 1. Redistributions of source code must retain the above copyright notice,
#    this list of conditions and the following disclaimer.
# 2. Redistributions in binary form must reproduce the above copyright notice,
#    this list of conditions and the following disclaimer in the documentation
#    and/or other materials provided with the distribution.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
# AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
# IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
# ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
# CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
# SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
# INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
# CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
# ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.
#
# The views and conclusions contained in the software and documentation are
# those of the authors and should not be interpreted as representing official
# policies, either expressed or implied, of any organization.
# #L%

cmake_minimum_required(VERSION 3.2.0)

# Default policy is from 3.2.0
cmake_policy(VERSION 3.2.0)

# For MSVC
enable_language(CXX)
# For feature tests with CMake 2.8.x
enable_language(C)

# Enable C++11 support universally, with C++14 where available
if(NOT CMAKE_CXX_STANDARD)
  set(CMAKE_CXX_STANDARD 14)
endif()
# Enable C99 support universally
if(NOT CMAKE_C_STANDARD)
  set(CMAKE_C_STANDARD 99)
endif()

list(APPEND CMAKE_MODULE_PATH
     "${CMAKE_CURRENT_LIST_DIR}/cmake")

include("${CMAKE_CURRENT_LIST_DIR}/cmake/BioFormatsCommon.cmake")

include(MavenVersion)
maven_version("${CMAKE_CURRENT_LIST_DIR}/pom.xml" maven-project maven-version maven-snapshot)

project("${maven-project}"
        VERSION "${maven-version}"
        LANGUAGES CXX)

include(cmake/Version.cmake)
git_version_info("OME Model" "${CMAKE_CURRENT_SOURCE_DIR}")

if("${PROJECT_SOURCE_DIR}" STREQUAL "${PROJECT_BINARY_DIR}")
  message(FATAL_ERROR "In-tree builds are not supported; please run cmake from a separate build directory.")
endif("${PROJECT_SOURCE_DIR}" STREQUAL "${PROJECT_BINARY_DIR}")

include(cmake/SourceArchive.cmake)
source_archive("${PROJECT_NAME}" "${PROJECT_VERSION}${OME_VCS_DEV}")

enable_language(CXX)
  set(BUILD_SHARED_LIBS_DEFAULT ON)
if(MSVC)
  set(BUILD_SHARED_LIBS_DEFAULT OFF)
endif()
set(BUILD_SHARED_LIBS ${BUILD_SHARED_LIBS_DEFAULT} CACHE BOOL "Use shared libraries")

include(GNUInstallDirs)
include(CompilerChecks)
include(PlatformChecks)
include(BoostChecks)
include(RegexChecks)
include(ThreadChecks)
include(XercesChecks)
include(XalanChecks)
include(XsdFu)
include(GTest)
include(Doxygen)
include(HeaderTest)

# This is a hack to generate the model sources without having to have
# ome-common available.  It will be removed or moved once the model
# has been split out.
option(model-source-only "Generate model source only" OFF)
if(NOT model-source-only)
  find_package(OMECompat 5.4.0 REQUIRED)
  find_package(OMECommon 5.4.0 REQUIRED)
else()
  add_library(OME::Compat INTERFACE IMPORTED)
  add_library(OME::Common INTERFACE IMPORTED)
endif()

if(MSVC)
  # Debug library suffix.
  set(CMAKE_DEBUG_POSTFIX "d")
  # Require dynamic linking and disable autolinking.
  add_definitions(-DBOOST_ALL_DYN_LINK -DBOOST_ALL_NO_LIB)
  # To prevent a lot of spam warnings about standard POSIX functions
  # and unsafe use of the standard library.
  add_definitions(-D_CRT_SECURE_NO_WARNINGS -D_SCL_SECURE_NO_WARNINGS)
endif()


if(NOT DEFINED OME_XML_INSTALL_PKGDATADIR)
  set(OME_XML_INSTALL_PKGDATADIR "${CMAKE_INSTALL_DATADIR}/ome/xml"
      CACHE PATH "OME-XML-specific datadir")
endif()

if (NOT DEFINED OME_XML_INSTALL_SCHEMADIR)
  set(OME_XML_INSTALL_SCHEMADIR "${CMAKE_INSTALL_DATADIR}/xml/ome"
      CACHE PATH "OME-XML schema directory")
endif()
if (NOT DEFINED OME_XML_INSTALL_TRANSFORMDIR)
  set(OME_XML_INSTALL_TRANSFORMDIR "${CMAKE_INSTALL_DATADIR}/xsl/ome"
      CACHE PATH "OME-XML transform directory")
endif()
if (NOT DEFINED OME_XML_INSTALL_SAMPLEDIR)
  set(OME_XML_INSTALL_SAMPLEDIR "${OME_XML_INSTALL_PKGDATADIR}/samples"
      CACHE PATH "OME XML sample directory")
endif()

foreach(dir
    DATADIR
    SCHEMADIR
    TRANSFORMDIR
    SAMPLEDIR
    )
  mark_as_advanced(OME_XML_INSTALL_${dir})
endforeach()

add_subdirectory(docs/doxygen)
add_subdirectory(docs/sphinx)
add_subdirectory(ome-xml)
