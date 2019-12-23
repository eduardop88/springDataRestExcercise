import com.people.training.restpagandsort.validators.RutValidator
import spock.lang.Specification

class rutValidatorSpec extends Specification {

    private RutValidator rutValidator = new RutValidator()

    def "Test the rut validation in RutValidator Positive"() {
        expect: "the rut is valid"
        rutValidator.validateRut("12-4")
    }

    def "Test the rut validation in RutValidator k verifier digit Positive"() {
        expect: "the rut is valid"
        rutValidator.validateRut("6-k")
    }

    def "Test the rut validation in RutValidator K verifier digit Positive"() {
        expect: "the rut is valid"
        rutValidator.validateRut("6-K")
    }

    def "Test the rut validation in RutValidator Negative"() {
        expect: "the rut is invalid"
        !rutValidator.validateRut("12-2")
    }

    def "Test the rut validation in RutValidator dots Negative"() {
        expect: "the rut is invalid"
        !rutValidator.validateRut("96.838.800-2")
    }

    def "Test the rut validation in RutValidator letters Negative"() {
        expect: "the rut is invalid"
        !rutValidator.validateRut("l2-2")
    }
}
