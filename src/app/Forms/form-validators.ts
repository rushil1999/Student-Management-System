import { AbstractControl } from "@angular/forms";

export function formValidatorIsNumeric(control: AbstractControl): { [key: string]: any } | null {

    if(isNaN(control.value)){
        return { "error" : true}
    }
    else{
        return null;
    }

}


