
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schema suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="intB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "intA",
    "intB"
})
@XmlRootElement(name = "Add")
public class Add {

    protected int intA;
    protected int intB;

    /**
     * Obtient la valeur de la propriete intA.
     * 
     */
    public int getIntA() {
        return intA;
    }

    /**
     * Definit la valeur de la propriete intA.
     * 
     */
    public void setIntA(int value) {
        this.intA = value;
    }

    /**
     * Obtient la valeur de la propriete intB.
     * 
     */
    public int getIntB() {
        return intB;
    }

    /**
     * Definit la valeur de la propriete intB.
     * 
     */
    public void setIntB(int value) {
        this.intB = value;
    }

}
