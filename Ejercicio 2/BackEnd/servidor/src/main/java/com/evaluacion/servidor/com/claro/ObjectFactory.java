
package com.evaluacion.servidor.com.claro;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.claro package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarNitValidos_QNAME = new QName("http://claro.com/", "listarNitValidos");
    private final static QName _ListarNitValidosResponse_QNAME = new QName("http://claro.com/", "listarNitValidosResponse");
    private final static QName _ValidarNit_QNAME = new QName("http://claro.com/", "validarNit");
    private final static QName _ValidarNitResponse_QNAME = new QName("http://claro.com/", "validarNitResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.claro
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarNitValidos }
     * 
     */
    public ListarNitValidos createListarNitValidos() {
        return new ListarNitValidos();
    }

    /**
     * Create an instance of {@link ListarNitValidosResponse }
     * 
     */
    public ListarNitValidosResponse createListarNitValidosResponse() {
        return new ListarNitValidosResponse();
    }

    /**
     * Create an instance of {@link ValidarNit }
     * 
     */
    public ValidarNit createValidarNit() {
        return new ValidarNit();
    }

    /**
     * Create an instance of {@link ValidarNitResponse }
     * 
     */
    public ValidarNitResponse createValidarNitResponse() {
        return new ValidarNitResponse();
    }

    /**
     * Create an instance of {@link ResponseModel }
     * 
     */
    public ResponseModel createResponseModel() {
        return new ResponseModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarNitValidos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarNitValidos }{@code >}
     */
    @XmlElementDecl(namespace = "http://claro.com/", name = "listarNitValidos")
    public JAXBElement<ListarNitValidos> createListarNitValidos(ListarNitValidos value) {
        return new JAXBElement<ListarNitValidos>(_ListarNitValidos_QNAME, ListarNitValidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarNitValidosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarNitValidosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://claro.com/", name = "listarNitValidosResponse")
    public JAXBElement<ListarNitValidosResponse> createListarNitValidosResponse(ListarNitValidosResponse value) {
        return new JAXBElement<ListarNitValidosResponse>(_ListarNitValidosResponse_QNAME, ListarNitValidosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarNit }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidarNit }{@code >}
     */
    @XmlElementDecl(namespace = "http://claro.com/", name = "validarNit")
    public JAXBElement<ValidarNit> createValidarNit(ValidarNit value) {
        return new JAXBElement<ValidarNit>(_ValidarNit_QNAME, ValidarNit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarNitResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidarNitResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://claro.com/", name = "validarNitResponse")
    public JAXBElement<ValidarNitResponse> createValidarNitResponse(ValidarNitResponse value) {
        return new JAXBElement<ValidarNitResponse>(_ValidarNitResponse_QNAME, ValidarNitResponse.class, null, value);
    }

}
