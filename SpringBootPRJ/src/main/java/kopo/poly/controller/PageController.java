package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class PageController {

    @GetMapping(value="/blank")
    public String blank() {
        log.info("blank start!");
        return "blank";
    }
    @GetMapping(value="/checkbox")
    public String checkbox() {
        log.info("checkbox start!");
        return "checkbox";
    }
    @GetMapping(value="/extended-ui-text-divider")
    public String extendedUiTextDivider() {
        log.info("extended-ui-text-divider start!");
        return "extended-ui-text-divider";
    }
    @GetMapping(value="/form-layouts-horizontal")
    public String formLayoutsHorizontal() {
        log.info("form-layouts-horizontal start!");
        return "form-layouts-horizontal";
    }
    @GetMapping(value="/forms-basic-inputs")
    public String formsBasicInputs() {
        log.info("forms-basic-inputs start!");
        return "forms-basic-inputs";
    }
    @GetMapping(value="/index")
    public String index() {
        log.info("index start!");
        return "index";
    }
    @GetMapping(value="/profile")
    public String profile() {
        log.info("profile start!");
        return "profile";
    }
    @GetMapping(value="/searchingBar")
    public String searchingBar() {
        log.info("searchingBar start!");
        return "searchingBar";
    }
    @GetMapping(value="/tables-basic")
    public String tablesBasic() {
        log.info("tables-basic start!");
        return "tables-basic";
    }
    @GetMapping(value="/ui-accordion")
    public String uiAccordion() {
        log.info("ui-accordion start!");
        return "ui-accordion";
    }
    @GetMapping(value="/ui-alerts")
    public String uiAlerts() {
        log.info("ui-alerts start!");
        return "ui-alerts";
    }
    @GetMapping(value="/ui-badges")
    public String uiBadges() {
        log.info("ui-badges start!");
        return "ui-badges";
    }
    @GetMapping(value="/ui-buttons")
    public String uiButtons() {
        log.info("ui-buttons start!");
        return "ui-buttons";
    }
    @GetMapping(value="/ui-collapse")
    public String uiCollapse() {
        log.info("ui-collapse start!");
        return "ui-collapse";
    }
    @GetMapping(value="/ui-dropdowns")
    public String uiDropdowns() {
        log.info("ui-dropdowns start!");
        return "ui-dropdowns";
    }
    @GetMapping(value="/ui-modals")
    public String uiModals() {
        log.info("ui-modals start!");
        return "ui-modals";
    }
    @GetMapping(value="/ui-pagination")
    public String uiPagination() {
        log.info("ui-pagination start!");
        return "ui-pagination";
    }
    @GetMapping(value="/ui-spinners")
    public String uiSpinners() {
        log.info("ui-spinners start!");
        return "ui-spinners";
    }
    @GetMapping(value="/ui-tabs-pills")
    public String uiTabsPills() {
        log.info("ui-tabs-pills start!");
        return "ui-tabs-pills";
    }
    @GetMapping(value="/ui-toasts")
    public String uiToasts() {
        log.info("ui-toasts start!");
        return "ui-toasts";
    }
    @GetMapping(value="/ui-typography")
    public String uiTypography() {
        log.info("ui-typography start!");
        return "ui-typography";
    }


}
