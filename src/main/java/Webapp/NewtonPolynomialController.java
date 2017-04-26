package Webapp;

import Core.NewtonPolynomial;
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

        model.put("interpolation", service.getInterpolationValues().toString());
        model.put("polynomialFormula", service.getPolynomialFormula());

        return model;
    }
}
