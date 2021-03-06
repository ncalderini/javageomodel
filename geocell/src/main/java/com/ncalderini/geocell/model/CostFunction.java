/*
Copyright 2010 Alexandre Gellibert

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/
LICENSE-2.0 Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an "AS IS"
BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing permissions
and limitations under the License.
*/

package com.ncalderini.geocell.model;

/**
 * Interface to create a cost function used in geocells algorithm.
 * This function will determine the cost of an operation depending of number of cells and resolution.
 * When the cost is going higher, the algorithm stops.
 * The cost depends on application use of geocells.
 *
 * @author Alexandre Gellibert
 *
 */
public interface CostFunction {

    /**
     * @param numCells number of cells found
     * @param resolution resolution of those cells
     * @return the cost of the operation
     */
    public double defaultCostFunction(int numCells, int resolution);

}
