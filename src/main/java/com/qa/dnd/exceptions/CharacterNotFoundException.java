package com.qa.dnd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The character you're looking for doesn't exist")
public class CharacterNotFoundException  extends EntityNotFoundException {
}
