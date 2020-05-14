package com.qa.mesadnd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This character does not exist")
public class CharacterNotFoundException extends EntityNotFoundException {
}
