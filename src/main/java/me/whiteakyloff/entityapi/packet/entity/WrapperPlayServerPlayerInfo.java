package me.whiteakyloff.entityapi.packet.entity;

import me.whiteakyloff.entityapi.packet.AbstractPacket;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import com.comphenix.protocol.wrappers.PlayerInfoData;

import java.util.List;

@SuppressWarnings("unused")
public class WrapperPlayServerPlayerInfo extends AbstractPacket 
{
	public static final PacketType TYPE =
			PacketType.Play.Server.PLAYER_INFO;

	public WrapperPlayServerPlayerInfo() {
		super(new PacketContainer(TYPE), TYPE);
		this.handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerPlayerInfo(PacketContainer packet) {
		super(packet, TYPE);
	}

	public PlayerInfoAction getAction() {
		return this.handle.getPlayerInfoAction().read(0);
	}

	public void setAction(PlayerInfoAction value) {
		this.handle.getPlayerInfoAction().write(0, value);
	}

	public List<PlayerInfoData> getData() {
		return this.handle.getPlayerInfoDataLists().read(0);
	}

	public void setData(List<PlayerInfoData> value) {
		this.handle.getPlayerInfoDataLists().write(0, value);
	}
}