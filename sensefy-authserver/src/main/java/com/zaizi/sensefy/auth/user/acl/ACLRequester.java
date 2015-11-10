/*******************************************************************************
 * Sensefy
 *
 * Copyright (c) Zaizi Limited, All rights reserved.
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 *******************************************************************************/
package com.zaizi.sensefy.auth.user.acl;

import java.util.List;

/**
 * ACL Requester. Make requests to get ACLs for an user
 * 
 * @author aayala
 * 
 */
public interface ACLRequester
{
    /**
     * Retuns a list of ACLs for an userName
     * 
     * @param userName
     * @return
     */
    List<String> getACLs(String userName);
}