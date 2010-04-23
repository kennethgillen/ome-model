/*
 * ome.xml.r201004.DetectorSettings
 *
 *-----------------------------------------------------------------------------
 *
 *  Copyright (C) @year@ Open Microscopy Environment
 *      Massachusetts Institute of Technology,
 *      National Institutes of Health,
 *      University of Dundee,
 *      University of Wisconsin-Madison
 *
 *
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *-----------------------------------------------------------------------------
 */

/*-----------------------------------------------------------------------------
 *
 * THIS IS AUTOMATICALLY GENERATED CODE.  DO NOT MODIFY.
 * Created by callan via xsd-fu on 2010-04-22 17:37:18+0100
 *
 *-----------------------------------------------------------------------------
 */

package ome.xml.r201004;

import java.util.ArrayList;
import java.util.List;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ome.xml.r201004.enums.*;

public class DetectorSettings extends Settings
{
	// -- Constants --

	public static final String NAMESPACE = "http://www.openmicroscopy.org/Schemas/OME/2010-04";

	// -- Instance variables --

	// Property
	private Binning binning;

	// Property
	private Double readOutRate;

	// Property
	private Double gain;

	// Property
	private Double offset;

	// Property
	private String id;

	// Property
	private Double voltage;

	// -- Constructors --

	/** Default constructor. */
	public DetectorSettings()
	{
		super();
	}

	/** 
	 * Constructs DetectorSettings recursively from an XML DOM tree.
	 * @param element Root of the XML DOM tree to construct a model object
	 * graph from.
	 * @throws EnumerationException If there is an error instantiating an
	 * enumeration during model object creation.
	 */
	public DetectorSettings(Element element) throws EnumerationException
	{
		update(element);
	}

	/** 
	 * Updates DetectorSettings recursively from an XML DOM tree. <b>NOTE:</b> No
	 * properties are removed, only added or updated.
	 * @param element Root of the XML DOM tree to construct a model object
	 * graph from.
	 * @throws EnumerationException If there is an error instantiating an
	 * enumeration during model object creation.
	 */
	public void update(Element element) throws EnumerationException
	{	
		super.update(element);
		String tagName = element.getTagName();
		if (!"DetectorSettings".equals(tagName))
		{
			System.err.println(String.format(
					"WARNING: Expecting node name of DetectorSettings got %s",
					tagName));
			// TODO: Should be its own Exception
			//throw new RuntimeException(String.format(
			//		"Expecting node name of DetectorSettings got %s",
			//		tagName));
		}
		if (element.hasAttribute("Binning"))
		{
			// Attribute property which is an enumeration Binning
			setBinning(Binning.fromString(
					element.getAttribute("Binning")));
		}
		if (element.hasAttribute("ReadOutRate"))
		{
			// Attribute property ReadOutRate
			setReadOutRate(Double.valueOf(
					element.getAttribute("ReadOutRate")));
		}
		if (element.hasAttribute("Gain"))
		{
			// Attribute property Gain
			setGain(Double.valueOf(
					element.getAttribute("Gain")));
		}
		if (element.hasAttribute("Offset"))
		{
			// Attribute property Offset
			setOffset(Double.valueOf(
					element.getAttribute("Offset")));
		}
		if (element.hasAttribute("ID"))
		{
			// Attribute property ID
			setID(String.valueOf(
					element.getAttribute("ID")));
		}
		if (element.hasAttribute("Voltage"))
		{
			// Attribute property Voltage
			setVoltage(Double.valueOf(
					element.getAttribute("Voltage")));
		}
	}

	// -- DetectorSettings API methods --


	// Property
	public Binning getBinning()
	{
		return binning;
	}

	public void setBinning(Binning binning)
	{
		this.binning = binning;
	}

	// Property
	public Double getReadOutRate()
	{
		return readOutRate;
	}

	public void setReadOutRate(Double readOutRate)
	{
		this.readOutRate = readOutRate;
	}

	// Property
	public Double getGain()
	{
		return gain;
	}

	public void setGain(Double gain)
	{
		this.gain = gain;
	}

	// Property
	public Double getOffset()
	{
		return offset;
	}

	public void setOffset(Double offset)
	{
		this.offset = offset;
	}

	// Property
	public String getID()
	{
		return id;
	}

	public void setID(String id)
	{
		this.id = id;
	}

	// Property
	public Double getVoltage()
	{
		return voltage;
	}

	public void setVoltage(Double voltage)
	{
		this.voltage = voltage;
	}

	public Element asXMLElement(Document document)
	{
		return asXMLElement(document, null);
	}

	protected Element asXMLElement(Document document, Element DetectorSettings_element)
	{
		// Creating XML block for DetectorSettings
		if (DetectorSettings_element == null)
		{
			DetectorSettings_element =
					document.createElementNS(NAMESPACE, "DetectorSettings");
		}

		if (binning != null)
		{
			// Attribute property Binning
			DetectorSettings_element.setAttribute("Binning", binning.toString());
		}
		if (readOutRate != null)
		{
			// Attribute property ReadOutRate
			DetectorSettings_element.setAttribute("ReadOutRate", readOutRate.toString());
		}
		if (gain != null)
		{
			// Attribute property Gain
			DetectorSettings_element.setAttribute("Gain", gain.toString());
		}
		if (offset != null)
		{
			// Attribute property Offset
			DetectorSettings_element.setAttribute("Offset", offset.toString());
		}
		if (id != null)
		{
			// Attribute property ID
			DetectorSettings_element.setAttribute("ID", id.toString());
		}
		if (voltage != null)
		{
			// Attribute property Voltage
			DetectorSettings_element.setAttribute("Voltage", voltage.toString());
		}
		return super.asXMLElement(document, DetectorSettings_element);
	}
}