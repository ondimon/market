//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.20 at 09:51:40 PM MSK 
//


package ru.dimon.market.ws.orders;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for orderWS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sum" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="status" type="{http://dimon.ru/market/ws/orders}orderStatus"/>
 *         &lt;element name="amountProducts" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderWS", propOrder = {
    "id",
    "created",
    "username",
    "sum",
    "status",
    "amountProducts"
})
public class OrderWS {

    protected long id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(required = true)
    protected String username;
    protected double sum;
    @XmlElement(required = true)
    protected OrderStatus status;
    @XmlElement(required = true)
    protected BigDecimal amountProducts;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the sum property.
     * 
     */
    public double getSum() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     */
    public void setSum(double value) {
        this.sum = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link OrderStatus }
     *     
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderStatus }
     *     
     */
    public void setStatus(OrderStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the amountProducts property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountProducts() {
        return amountProducts;
    }

    /**
     * Sets the value of the amountProducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountProducts(BigDecimal value) {
        this.amountProducts = value;
    }

}