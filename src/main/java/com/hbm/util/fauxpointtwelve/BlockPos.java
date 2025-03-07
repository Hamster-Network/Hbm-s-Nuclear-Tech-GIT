package com.hbm.util.fauxpointtwelve;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

/**
 * Adjusted code from MC 1.12 (com.minecraft.util.math.BlockPos)
 */
public class BlockPos {
	
	private final int x;
	private final int y;
	private final int z;

	public BlockPos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public BlockPos(TileEntity te) {
		this(te.xCoord, te.yCoord, te.zCoord);
	}
	
	public BlockPos(double x, double y, double z) {
		this((int)MathHelper.floor_double(x), (int)MathHelper.floor_double(y), (int)MathHelper.floor_double(z));
	}
	
	public BlockPos add(double x, double y, double z) {
		return x == 0.0D && y == 0.0D && z == 0.0D ? this : new BlockPos((double) this.getX() + x, (double) this.getY() + y, (double) this.getZ() + z);
	}
	
	public BlockPos add(BlockPos vec) {
		return this.add(vec.getX(), vec.getY(), vec.getZ());
	}
	
	public BlockPos rotate(Rotation rotationIn) {
		switch(rotationIn) {
		case NONE:
		default: return this;
		case CLOCKWISE_90: return new BlockPos(-this.getZ(), this.getY(), this.getX());
		case CLOCKWISE_180: return new BlockPos(-this.getX(), this.getY(), -this.getZ());
		case COUNTERCLOCKWISE_90: return new BlockPos(this.getZ(), this.getY(), -this.getX());
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getZ() {
		return this.z;
	}
}
