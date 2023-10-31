package test.main;

import test.mypac.Airplane;
import test.mypac.Test;

public class MainClass02 {
	public static void main(String[] args) {
		Test t = new Test();
		t.doSomething(10, "lee", new Airplane());
		t.send();
		t.send(10);
		t.send("kim");
		t.send(new Airplane());
	}
}
