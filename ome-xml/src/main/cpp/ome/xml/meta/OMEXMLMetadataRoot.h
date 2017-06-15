/*
 * #%L
 * OME-XML C++ library for working with OME-XML metadata structures.
 * Copyright © 2006 - 2016 Open Microscopy Environment:
 *   - Massachusetts Institute of Technology
 *   - National Institutes of Health
 *   - University of Dundee
 *   - Board of Regents of the University of Wisconsin-Madison
 *   - Glencoe Software, Inc.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of any organization.
 * #L%
 */

#ifndef OME_XML_OME_OMEXMLMETADATAROOT_H
#define OME_XML_OME_OMEXMLMETADATAROOT_H

#include <cstdint>

#include <ome/xml/meta/MetadataRoot.h>
#include <ome/xml/model/OME.h>

namespace ome
{
  namespace xml
  {
    namespace meta
    {

      /**
       * OME-XML metadata root node.
       */
      class OMEXMLMetadataRoot : public ::ome::xml::model::OME,
				 virtual public ::ome::xml::meta::MetadataRoot
      {
      public:
        /// Constructor.
        OMEXMLMetadataRoot();

	/**
         * Copy constructor.
         *
         * @param copy the instance to copy.
         */
	OMEXMLMetadataRoot(const OMEXMLMetadataRoot& copy);

	/**
         * Copy constructor.
         *
         * @param copy the instance to copy.
         */
	OMEXMLMetadataRoot(const xml::model::OME& copy);

      public:
        /// Destructor.
        virtual
        ~OMEXMLMetadataRoot();

        /// @cond SKIP
        OMEXMLMetadataRoot&
        operator= (const OMEXMLMetadataRoot&) = delete;
        /// @endcond SKIP
      };

    }
  }
}

#endif // OME_XML_OME_OMEXMLMETADATAROOT_H

/*
 * Local Variables:
 * mode:C++
 * End:
 */