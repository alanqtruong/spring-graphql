package com.example.spring.graph.ql.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * @author alanqtruong
 */
public class ResponseMessage implements Serializable {

  private String message;
  private Date date;

  public ResponseMessage(String message, Date date) {
    this.message = message;
    this.date = date;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "ResponseMessage{" +
        "message='" + message + '\'' +
        ", date=" + date +
        '}';
  }
}
