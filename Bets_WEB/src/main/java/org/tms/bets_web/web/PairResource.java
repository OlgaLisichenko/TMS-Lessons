package org.tms.bets_web.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tms.bets_web.dto.Pair;
import org.tms.bets_web.service.BetsService;
import org.tms.bets_web.service.HorseRaceService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/pairs")
@AllArgsConstructor
public class PairResource {

    private BetsService betsService;
    private HorseRaceService horseRaceService;

    @GetMapping
    public ModelAndView get() {
        Map<String, Object> model = new HashMap<>();
        model.put("totalSum", betsService.getTotalSum());
        model.put("pairs", horseRaceService.getPairs());
        return new ModelAndView("home", model);
    }

    @PostMapping
    public ModelAndView createPairs(@Valid Pair pair, BindingResult result) {
        Map<String, Object> model = new HashMap<>();

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("home", model);
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError error : fieldErrors) {
                errors.put("error_" + error.getField(), error.getDefaultMessage());
            }
            modelAndView.addAllObjects(errors);
            return modelAndView;
        }
        model.put("totalSum", betsService.getTotalSum());
        model.put("pairs", horseRaceService.addPair(pair));
        return new ModelAndView("home", model);
    }

    @PostMapping(value = "/bet")
    public ModelAndView createBet(int betPair, int betSum) {
        Map<String, Object> model = new HashMap<>();
        int raceLeader = horseRaceService.getRaceLeader();
        int pairForBet = betsService.getPairForBet(betPair);
        if (pairForBet != 0) {
            model.put("pairForBet", pairForBet);
            model.put("leadNumber", raceLeader);
            model.put("totalSum", betsService.getTotalSum(betsService.getPairForBet(), betSum, raceLeader));
        } else {
            model.put("pairForBet", pairForBet);
            model.put("totalSum", betsService.getTotalSum());
        }
        return new ModelAndView("bet", model);
    }
}