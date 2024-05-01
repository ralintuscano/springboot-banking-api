package org.example.ralin_bank_app_demo.models.responseModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericSuccessResponseDTO<T> {

    private Boolean success;
    private CustomMetaDataDTO meta;
    private T data;

}