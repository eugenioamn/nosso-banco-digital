package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.dto.AddressDTO;
import com.eugeniomoreira.nossobancodigital.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AddressServiceImpl implements AddressService {

    private static final String CEP_PATTERN = "[0-9]{5}-[\\d]{3}";

    private static final Pattern patternCep = Pattern.compile(CEP_PATTERN, Pattern.CASE_INSENSITIVE);

    public AddressServiceImpl() {
    }

    public void validation(AddressDTO addressDTO) {
        Optional.ofNullable(addressDTO.getPostalCode())
                .filter(postalCode -> {
                    Matcher matcher = patternCep.matcher(postalCode);
                    return matcher.matches();
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid postal code"));

        Optional.ofNullable(addressDTO.getStreet())
                .filter(street -> !street.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Street not sent"));

        Optional.ofNullable(addressDTO.getNeighborhood())
                .filter(neighborhood -> !neighborhood.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Neighborhood not sent"));

        Optional.ofNullable(addressDTO.getComplement())
                .filter(complement -> !complement.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Complement not sent"));

        Optional.ofNullable(addressDTO.getCity())
                .filter(city -> !city.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "City not sent"));

        Optional.ofNullable(addressDTO.getState())
                .filter(state -> !state.isBlank())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "State not sent"));
    }

}
