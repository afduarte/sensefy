/**
 * (C) Copyright 2015 Zaizi Limited (http://www.zaizi.com).
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 3.0 which accompanies this distribution, and is available at 
 * http://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 **/
package org.zaizi.sensefy.api.utils;

import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;

/**
 * @Author: Alessandro Benedetti
 * Date: 14/05/2014
 */
public class PrimaryDocumentUtils
{


    /**
     * Sometimes the primary document Id has special characters and need to be escaped to allow a correct retrieval by Solr
     * @param local
     * @return
     */
    public static String escapeLocalPrimaryDocumentId( String local )
    {
        return local.replaceAll( "\\s", "%20" ).replaceAll( "\\?", "%3F" ).
            replaceAll( "\\@", "%40" ).replaceAll( "\\>", "%3E" ).replaceAll( "\\<", "%3C" );
    }

    /**
     * Return the namespace of a URI, that is everything before the last /
     * @param uri
     * @return
     * @throws java.net.MalformedURLException
     */
    public static String getNamespace( String uri )
        throws MalformedURLException
    {
        UrlValidator urlValidator = new UrlValidator();
        if ( uri.contains( "/" ) )
        {
            int lastSlashPosition = uri.lastIndexOf( "/" );
            return uri.substring( 0, lastSlashPosition + 1 );
        }
        else
        {
            return new String( uri );
        }
    }

    public static String getLocalName( String uri )
        throws MalformedURLException
    {
        if ( uri.contains( "/" ) )
        {
            int lastSlashPosition = uri.lastIndexOf( "/" );
            return uri.substring( lastSlashPosition + 1 );
        }
        else
        {
            return new String( uri );
        }
    }
}
