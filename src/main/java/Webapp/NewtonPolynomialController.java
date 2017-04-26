package Webapp;

import Core.NewtonPolynomial;
import Core.TheoreticalError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashepelsky on 4/25/2017.
 */
@RestController
public class NewtonPolynomialController {


    @RequestMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();

        NewtonPolynomial service = new NewtonPolynomial();

        model.put("x",service.getX());
        model.put("y",service.getY());
        model.put("interpolation", service.getInterpolationValues());
        model.put("polynomialFormula", service.getPolynomialFormula());

        return model;
    }

    @RequestMapping("/api/{x}")
    public Map<String, Object> xValues(@PathVariable double x) {
        Map<String, Object> model = new HashMap<String, Object>();

        NewtonPolynomial service = new NewtonPolynomial();
        service.getInterpolationValues();

        model.put("polynomialValue",service.calculatePolynomial(x));
        model.put("theoreticalError", new TheoreticalError().getTheoreticalError(x));

        return model;
    }
}
