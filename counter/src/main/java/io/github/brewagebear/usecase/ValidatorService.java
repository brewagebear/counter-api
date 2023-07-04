package io.github.brewagebear.usecase;

import io.github.brewagebear.usecase.exceptions.ValidateException;
import io.github.brewagebear.usecase.validator.IPv4Validator;
import io.github.brewagebear.usecase.validator.UrlValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    private final IPv4Validator iPv4Validator;
    private final UrlValidator urlValidator;

    public ValidatorService(IPv4Validator iPv4Validator, UrlValidator urlValidator) {
        this.iPv4Validator = iPv4Validator;
        this.urlValidator = urlValidator;
    }

    public void validate(String namespace, String key) {
        validateNamespace(namespace);
    }

    private void validateNamespace(String namespace) {
        if(!iPv4Validator.isValidIPv4(namespace) && (!urlValidator.isValidURL(namespace))){
                throw new ValidateException("Invalid namespace : " + namespace);
        }
    }
}
