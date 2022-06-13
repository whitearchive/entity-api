package me.whiteakyloff.entityapi.packet.entity;

import me.whiteakyloff.entityapi.packet.AbstractPacket;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

import org.bukkit.World;
import org.bukkit.entity.Entity;

@SuppressWarnings("unused")
public class WrapperPlayServerEntityHeadRotation extends AbstractPacket 
{
	public static final PacketType TYPE =
			PacketType.Play.Server.ENTITY_HEAD_ROTATION;

	public WrapperPlayServerEntityHeadRotation() {
		super(new PacketContainer(TYPE), TYPE);
		this.handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerEntityHeadRotation(PacketContainer packet) {
		super(packet, TYPE);
	}

	public int getEntityID() {
		return this.handle.getIntegers().read(0);
	}

	public void setEntityID(int value) {
		this.handle.getIntegers().write(0, value);
	}

	public Entity getEntity(World world) {
		return this.handle.getEntityModifier(world).read(0);
	}

	public Entity getEntity(PacketEvent event) {
		return this.getEntity(event.getPlayer().getWorld());
	}

	public byte getHeadYaw() {
		return this.handle.getBytes().read(0);
	}

	public void setHeadYaw(byte value) {
		this.handle.getBytes().write(0, value);
	}
}