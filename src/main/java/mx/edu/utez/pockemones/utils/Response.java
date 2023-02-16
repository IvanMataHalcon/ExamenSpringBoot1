package mx.edu.utez.pockemones.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response<T> {
    T data;
    private boolean error;
    private int status;
    private String message;

}
