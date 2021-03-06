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
package de.tudarmstadt.ukp.experiments.inviedit.client.ckeditor.versioncontrol.events.user;

import java.util.Date;

import de.tudarmstadt.ukp.experiments.inviedit.client.ckeditor.versioncontrol.VersionManagement;
import de.tudarmstadt.ukp.experiments.inviedit.client.marker.AMarker;
import de.tudarmstadt.ukp.experiments.inviedit.shared.marker.MarkerType;
import de.tudarmstadt.ukp.experiments.inviedit.shared.version.events.UserEventTransport;
import de.tudarmstadt.ukp.experiments.inviedit.shared.version.events.UserEventType;

/**
 * This class represents an event triggered by the user. It is logged for
 * version control and for tracking user actions.
 */
public abstract class UserEvent {

	/**
	 * Time in milliseconds at which the event occurred. Note: This timestamp is
	 * generated by the client side time. Therefore times generated by different
	 * clients might differ. Therefore they should be used as relative times
	 * regarding one client.
	 */
	protected long timestamp;

	/**
	 * At which point of the version this {@link EditorDeleteEvent} is
	 * associated with the event happened
	 */
	protected int versionPosition;

	/**
	 * Constructor should be called by all implementing classes. It sets the
	 * time stamp for this {@link UserEvent} according to client side time.
	 */
	public UserEvent(VersionManagement versionManagement) {
		this.timestamp = new Date().getTime();
	}

	/**
	 * @return {@link UserEventType} of this {@link UserEvent}. Serves as
	 *         distinction for subclasses
	 */
	public abstract UserEventType getUserEventType();

	/**
	 * @return Timestamp of this {@link UserEvent}
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Transforms all text positions of a marker according to this
	 * {@link UserEvent}. <br>
	 * This method must not ensure that the marker is in a correct state. <br>
	 * Precondition: {@link AMarker} is updated to the state before this event
	 * happened. <br>
	 * Action: Marker positions are updated such that the marker positions are
	 * correct for the state after this event happened. {@link AMarker}
	 * destroyed if the position update invalidated the {@link AMarker} <br>
	 * Postcondition: If {@link AMarker} is destroyed the return value is set to
	 * false. The {@link AMarker} state must no longer be guaranteed to be
	 * clean! (But may so for certain {@link MarkerType}s)
	 *
	 * @param marker
	 *            {@link AMarker} to perform position updates according to this
	 *            {@link UserEvent} for. It has to be ensured that all positions
	 *            of the given {@link AMarker} are in a state directly preceding
	 *            this {@link UserEvent}
	 * @return True if the {@link AMarker} was updated correctly, false if the
	 *         {@link AMarker} was invalidated by this event and was destroyed.
	 */
	public abstract boolean transformMarker(AMarker marker);

	/**
	 * @param versionPosition Sets versionPosition of this {@link UserEvent}
	 */
	public void setVersionPosition(int versionPosition) {
		this.versionPosition = versionPosition;
	}

	@Override
	public abstract String toString();

	public abstract UserEventTransport getTransportEvent();

}
