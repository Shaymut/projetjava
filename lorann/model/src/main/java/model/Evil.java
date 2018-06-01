package model;

public class Evil extends Mobile implements EvilMove, Kill{

	Evil(Permeability permeability, char sprite, Position position) {
		super(permeability, sprite, position);
	}

}
