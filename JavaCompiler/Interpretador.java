public class Interpretador {
    int Interpretar(ArvoreSintatica arv){
        if(arv instanceof Mult){
        	return (Interpretar(((Mult) arv).arg1) * Interpretar(((Mult)arv).arg2));
        }
        if(arv instanceof Soma){
        	return (Interpretar(((Soma) arv).arg1) + Interpretar(((Soma)arv).arg2));
        }
        if(arv instanceof Div){
        	return (Interpretar(((Div) arv).arg1) / Interpretar(((Div)arv).arg2));
        }
        if(arv instanceof Sub){
        	return (Interpretar(((Sub) arv).arg1) - Interpretar(((Sub)arv).arg2));
        }
        if(arv instanceof Num){
        	return (((Num) arv).num);
        }
        return 0;
	}
}