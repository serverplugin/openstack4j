/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.openstack.networking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.network.ExternalGateway;

import com.google.common.base.MoreObjects;

/**
 * Configurable external gateway modes extension model.  By default, when a gateway is attached to a router using the Neutron L3 extension,
 * Network Address Translation (NAT) is enabled for traffic generated by subnets attached to the router. With this extension, the user will
 * have the option of choosing whether SNAT should be enabled or not on a router basis.
 *
 * @author Jeremy Unruh
 * @see http://docs.openstack.org/api/openstack-network/2.0/content/extgwmodes-ext.html
 */
public class NeutronExternalGateway implements ExternalGateway {

	private static final long serialVersionUID = 1L;

	@JsonProperty("network_id")
	private String networkId;

	@JsonProperty("enable_snat")
	private Boolean enableSnat;

	public NeutronExternalGateway() { }

	public NeutronExternalGateway(String networkId) {
	  this(networkId, Boolean.TRUE);
	}

	public NeutronExternalGateway(String networkId, Boolean enableSnat) {
		this.networkId = networkId;
		this.enableSnat = enableSnat;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNetworkId() {
		return networkId;
	}

	/**
	 * {@inheritDoc}
	 */
	@JsonIgnore
	@Override
	public boolean isEnableSnat() {
		return enableSnat != null && enableSnat;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				    .add("networkId", networkId).add("enable_snat", enableSnat).toString();
	}

}