package edu.hneu.kpp.lab2.spring.webapp.controller;

import edu.hneu.kpp.lab2.spring.service.service.PublishingHouseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(ControllerConstants.PUBLISHING_HOUSE_CONTROLLER_REQUEST_MAPPING)
public class PublishingHouseController {
    private static final String VIEW_LIST_NAME = "pHouseList";
    private static final String MODEL_LIST_NAME = "pHouseListModel";
    private static final String VIEW_SINGLE_NAME = "pHouse";
    private static final String MODEL_SINGLE_NAME = "pHouseModel";

    @Resource
    private PublishingHouseService publishingHouseService;

    @GetMapping
    public ModelAndView get(@RequestParam(required = false) Integer id) {
        if (null == id) {
            return new ModelAndView(VIEW_LIST_NAME, MODEL_LIST_NAME, publishingHouseService.findAll());
        } else {
            return new ModelAndView(VIEW_SINGLE_NAME, MODEL_SINGLE_NAME, publishingHouseService.findById(id));
        }
    }
}
