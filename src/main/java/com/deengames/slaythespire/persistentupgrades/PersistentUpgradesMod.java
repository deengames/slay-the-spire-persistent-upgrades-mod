package com.deengames.slaythespire.easymode;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.OnStartBattleSubscriber;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpireInitializer
public class PersistentUpgradesMod implements ISubscriber {

	public static void initialize() {
        new PersistentUpgradesMod();
    }
	
	public PersistentUpgradesMod() {
		BaseMod.subscribe(this);
	}
}
