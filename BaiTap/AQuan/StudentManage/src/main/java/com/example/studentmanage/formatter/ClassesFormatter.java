package com.example.studentmanage.formatter;

import com.example.studentmanage.model.Classes;
import com.example.studentmanage.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ClassesFormatter implements Formatter<Classes> {

    private IClassesService classesService;

    @Autowired
    public ClassesFormatter(IClassesService classesService) {
        this.classesService = classesService;
    }

    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        Optional<Classes> provinceOptional = classesService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Classes object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
