package org.example.spring_boot_bank_api.controllers;


import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot_bank_api.models.dtos.response.errors.CustomErrorMessage;
import org.example.spring_boot_bank_api.models.dtos.response.generic_response.CustomMetaDataDTO;
import org.example.spring_boot_bank_api.models.dtos.response.generic_response.GenericSuccessResponseDTO;
import org.example.spring_boot_bank_api.models.dtos.response.WelcomeResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class Welcome {



//    Logger logger = LoggerFactory.getLogger(Welcome.class);

    @GetMapping("/welcome")
    @ResponseStatus(HttpStatus.OK)
    public GenericSuccessResponseDTO<Object> welcome(){

        CustomMetaDataDTO metaDataDTO = CustomMetaDataDTO.builder()
                .code(HttpStatus.OK)
                .message("Welcome to Chase Bank App")
                .build();

        return GenericSuccessResponseDTO.builder()
                .meta(metaDataDTO)
                .data(Arrays.asList("ac1", "ac2", "ac3"))
                .success(true)
                .build();
    }

    @GetMapping("/error")
    public WelcomeResponseModel CustomErrorTest() throws CustomErrorMessage {
        log.error("Log level: ERROR", "HEY, WE're SORRY");
        throw new CustomErrorMessage("Hey! We're Sorry");
    }

    @GetMapping("/checkGenerics/{text}")
    public List<String> genericsTest(@PathVariable("text") String element){
        List<? extends Number> list = Arrays.asList(new Double(2.2), new Integer(4));

        Iterator<? extends Number> listIterator = list.iterator();

        listIterator.forEachRemaining(out::println);

        return convertToString(list);
    }

    public static List<String> convertToString(List<? extends Number> list){
        return list.stream().map(Object::toString).toList();
    }

}
