package com.qa.dnd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The proficiencies for this character don't exist")
public class ProficienciesNotFoundException extends EntityNotFoundException {
}
