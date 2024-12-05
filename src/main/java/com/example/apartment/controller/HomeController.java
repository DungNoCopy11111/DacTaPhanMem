package com.example.apartment.controller;

import com.example.apartment.dto.ApartmentDTO;
import com.example.apartment.exception.ResourceNotFoundException;
import com.example.apartment.model.Can;
import com.example.apartment.model.ThietBi;
import com.example.apartment.service.ApartmentService;
import com.example.apartment.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/")
    public String home() {
        return "redirect:/admin/home";
    }

    @GetMapping("/admin/home")
    public String adminHome(@RequestParam(name = "layout",defaultValue = "admin/dashboard/general" ) String layout, Model model) {
        model.addAttribute("layout", layout);
        return "admin/index";
    }

    @GetMapping("admin/apartment")
    public String showApartment(Model model){
        model.addAttribute("apartments",apartmentService.getAllCan());
        return "admin/property/property-listing";
    }

    @GetMapping("admin/device")
    public String showDevice(Model model){
        model.addAttribute("devices",deviceService.getAllThietBi());
        List<ThietBi> device = deviceService.getAllThietBi();
        log.info("show devices");
        return "admin/device/device-listing";
    }

    @GetMapping("admin/edit/{thietBiId}")
    public String showEditDevice(@PathVariable("thietBiId") Long thietBiId, Model model){
        ThietBi devicecurrent = deviceService.getThietBiById(thietBiId)
                .orElseThrow(() -> new ResourceNotFoundException("ThietBi", "id", thietBiId));
        model.addAttribute("devicecurrent",devicecurrent);
        log.info("show edit");
        return "admin/device/edit-device";
    }

    @PostMapping("admin/update/{thietBiId}")
    public RedirectView updateDevice(@PathVariable("thietBiId") Long thietBiId, @Validated @ModelAttribute("devicecurrent") ThietBi thietBi) {
        try {
            deviceService.update(thietBi);
            log.info("edit");
            return new RedirectView("/admin/device");
        } catch (Exception e) {
            log.error("Update or Edit failed", e);
            return new RedirectView("/login?error=true");
        }
    }
    @GetMapping("admin/editApartment/{maCan}")
    public String showEditApartment(@PathVariable("maCan") String maCan, Model model){
        ApartmentDTO can = apartmentService.getApartment(maCan)
                .orElseThrow(() -> new ResourceNotFoundException("CanHo: ", "id", maCan));
        model.addAttribute("apartmentcurrent",can);
        log.info("show edit");
        return "admin/property/edit-apartment";
    }

    @PostMapping("admin/updateApartment/{maCan}")
    public RedirectView updateApartment(@PathVariable("maCan") String maCan, @Validated @ModelAttribute("apartmentcurrent") ApartmentDTO apartmentDTO) {
        try {
            log.info("update apartment");
            apartmentService.updateApartment(apartmentDTO);
            return new RedirectView("/admin/apartment");
        } catch (Exception e) {
            log.error("Update or Edit failed", e);
            return new RedirectView("/login?error=true");
        }
    }
}
