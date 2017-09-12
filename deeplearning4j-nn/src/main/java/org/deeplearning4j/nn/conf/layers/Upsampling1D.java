/*-
 *
 *  * Copyright 2017 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */
package org.deeplearning4j.nn.conf.layers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.deeplearning4j.nn.api.ParamInitializer;
import org.deeplearning4j.nn.conf.InputPreProcessor;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.memory.LayerMemoryReport;
import org.deeplearning4j.nn.conf.memory.MemoryReport;
import org.deeplearning4j.nn.params.EmptyParamInitializer;
import org.deeplearning4j.optimize.api.IterationListener;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.util.Collection;
import java.util.Map;

/**
 * Upsampling 1D layer
 *
 * @author Max Pumperla
 */

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Upsampling1D extends Upsampling2D {

    protected int size;

    protected Upsampling1D(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    @Override
    public Upsampling1D clone() {
        Upsampling1D clone = (Upsampling1D) super.clone();
        return clone;
    }

    @NoArgsConstructor
    public static class Builder extends Upsampling2D.Upsampling2DBuilder {

        public Builder(int size) {
            super(size);
        }

        /**
         * Upsampling size
         *
         * @param size    upsampling size in height and width dimensions
         */
        public Builder size(int size) {

            this.size = size;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Upsampling1D build() {
            return new Upsampling1D(this);
        }
    }

}