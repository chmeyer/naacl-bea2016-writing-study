/*******************************************************************************
 * Copyright 2016
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.experiments.inviedit.shared.version;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

import de.tudarmstadt.ukp.experiments.inviedit.shared.marker.MarkerTransport;
import de.tudarmstadt.ukp.experiments.inviedit.shared.version.message.response.ResponseMessage;

public class VersionResponse implements IsSerializable{

	private ArrayList<MarkerTransport> newMarkers;
	private ArrayList<ResponseMessage> responseMessages;

	/**
	 * GWT serialization required
	 */
	@SuppressWarnings("unused")
	private VersionResponse(){}

	public VersionResponse(ArrayList<MarkerTransport> newMarkers,
			ArrayList<ResponseMessage> responseMessages) {
		super();
		this.newMarkers = newMarkers;
		this.responseMessages = responseMessages;
	}

	public ArrayList<MarkerTransport> getNewMarkers() {
		return newMarkers;
	}

	public ArrayList<ResponseMessage> getResponseMessages() {
		return responseMessages;
	}

}
