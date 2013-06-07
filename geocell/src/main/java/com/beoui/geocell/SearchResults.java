/*******************************************************************************
 * Copyright 2012 Apigee Corporation
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
package com.beoui.geocell;

import java.util.List;

/**
 * A simple wrapper class that contains the results. It also contains the last
 * tile we searched (to resume searching at this tile) and the last match within
 * that tile (to discard all values less than this on the next pass)
 * 
 * @author tnine
 * 
 */
public class SearchResults<T> {

  public static final double NO_RESULTS = -1;
  
  private final List<T> results;
  private final double lastDistance;
  private final int lastResolution;

  /**
   * @param results
   * @param nextStartTile
   * @param lastMatched
   */
  public SearchResults(List<T> results, double lastDistance, int lastResolution) {
    super();
    this.results = results;
    this.lastDistance = lastDistance;
    this.lastResolution = lastResolution;
  }

  public List<T> getResults() {
    return results;
  }

  public double getLastDistance() {
    return lastDistance;
  }

  /**
   * Return the last resolution that was searched
   * @return the lastResolution 
   */
  public int getLastResolution() {
    return lastResolution;
  }

  
}
