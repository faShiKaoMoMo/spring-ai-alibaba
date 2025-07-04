/*
 * Copyright 2024-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.cloud.ai.dashscope.audio.synthesis;

import org.springframework.ai.model.ModelResponse;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author kevinlin09
 */
public class SpeechSynthesisResponse implements ModelResponse<SpeechSynthesisResult> {

	private final SpeechSynthesisResult result;

	private final SpeechSynthesisResponseMetadata metadata;

	public SpeechSynthesisResponse(SpeechSynthesisResult result) {
		this(result, SpeechSynthesisResponseMetadata.NULL);
	}

	public SpeechSynthesisResponse(SpeechSynthesisResult result, SpeechSynthesisResponseMetadata metadata) {
		this.result = result;
		this.metadata = metadata;
	}

	@Override
	public SpeechSynthesisResult getResult() {
		return this.result;
	}

	@Override
	public List<SpeechSynthesisResult> getResults() {
		return Collections.singletonList(this.result);
	}

	@Override
	public SpeechSynthesisResponseMetadata getMetadata() {
		return this.metadata;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SpeechSynthesisResponse that)) {
			return false;
		}
		return Objects.equals(this.result, that.result) && Objects.equals(this.metadata, that.metadata);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.result, this.metadata);
	}

}
