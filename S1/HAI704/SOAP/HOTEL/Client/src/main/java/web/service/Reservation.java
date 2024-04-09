
package web.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chambreReservee" type="{http://service.web/}chambre" minOccurs="0"/>
 *         &lt;element name="client" type="{http://service.web/}client" minOccurs="0"/>
 *         &lt;element name="dateArrivee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://service.web/}hotel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "chambreReservee",
    "client",
    "dateArrivee",
    "dateDepart",
    "hotel"
})
public class Reservation {

    protected Chambre chambreReservee;
    protected Client client;
    protected String dateArrivee;
    protected String dateDepart;
    @XmlElement(namespace = "http://service.web/")
    protected Hotel hotel;

    /**
     * Obtient la valeur de la propriété chambreReservee.
     * 
     * @return
     *     possible object is
     *     {@link Chambre }
     *     
     */
    public Chambre getChambreReservee() {
        return chambreReservee;
    }

    /**
     * Définit la valeur de la propriété chambreReservee.
     * 
     * @param value
     *     allowed object is
     *     {@link Chambre }
     *     
     */
    public void setChambreReservee(Chambre value) {
        this.chambreReservee = value;
    }

    /**
     * Obtient la valeur de la propriété client.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Définit la valeur de la propriété client.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Obtient la valeur de la propriété dateArrivee.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateArrivee() {
        return dateArrivee;
    }

    /**
     * Définit la valeur de la propriété dateArrivee.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateArrivee(String value) {
        this.dateArrivee = value;
    }

    /**
     * Obtient la valeur de la propriété dateDepart.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateDepart() {
        return dateDepart;
    }

    /**
     * Définit la valeur de la propriété dateDepart.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDepart(String value) {
        this.dateDepart = value;
    }

    /**
     * Obtient la valeur de la propriété hotel.
     * 
     * @return
     *     possible object is
     *     {@link Hotel }
     *     
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Définit la valeur de la propriété hotel.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel }
     *     
     */
    public void setHotel(Hotel value) {
        this.hotel = value;
    }

}
