package org.example.spring_boot_bank_api.models.responseModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericSuccessResponseDTO<T> {

    private Boolean success;
    private CustomMetaDataDTO meta;
    private T data;

}