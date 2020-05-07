package com.qa.dnd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The skills you're looking for don't exist")
public class SkillsNotFoundException extends EntityNotFoundException {
}
