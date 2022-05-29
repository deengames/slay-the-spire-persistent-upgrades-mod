package com.deengames.slaythespire.easymode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.PostDeathSubscriber;
import basemod.interfaces.StartGameSubscriber;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpireInitializer
/// Stores the number of games played in a text file; uses that to determine amount of upgrades.
public class PersistentUpgradesMod implements ISubscriber, StartGameSubscriber, PostDeathSubscriber {

	private final String DATA_FILE_NAME = "PersistentUpgradesMod.dat";

	public static void initialize() {
        new PersistentUpgradesMod();
    }
	
	public PersistentUpgradesMod() {
		BaseMod.subscribe(this);
	}

	public void receiveStartGame() {
		int numGames = getNumGames();
		// TODO: apply 2n max HP, 1n strength, 1n metalicize
	}

	public void receivePostDeath() {
		int numGames = getNumGames();
		numGames += 1;

		setNumGames(numGames);
	}

	private int getNumGames() {
		if (!Files.exists(Paths.get(DATA_FILE_NAME)))
		{
			return 0;
		}

		try {
			List<String> lines = Files.readAllLines(Paths.get(DATA_FILE_NAME));
			final String contents = String.join("\n", lines);
			final int numGames = Integer.parseInt(contents);
			return numGames;
		} catch (IOException e)
		{
			return 0;
		}
	}

	private void setNumGames(int numGames) {
		try {
			final String contents = String.valueOf(numGames);
			final byte[] asByte = contents.getBytes();
			Files.write(Paths.get(DATA_FILE_NAME), asByte);
		} catch (IOException e)
		{

		}
	}
}
