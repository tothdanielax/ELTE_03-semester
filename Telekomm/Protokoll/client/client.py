import struct
import sys

# feladat1

for i, arg in enumerate(sys.argv):

    if i > 0:
        with open(arg, "rb") as f:

            data = f.read()
            unpacked_data = None

            if i == 1:
                unpacker = struct.Struct('f ? c')
                unpacked_data = unpacker.unpack(data)

            elif i == 2:
                unpacker = struct.Struct('c 9s i')
                unpacked_data = unpacker.unpack(data)

            elif i == 3:
                unpacker = struct.Struct('i ? f')
                unpacked_data = unpacker.unpack(data)

            elif i == 4:
                unpacker = struct.Struct('s f 9s')
                unpacked_data = unpacker.unpack(data)

            print(unpacked_data)

# feladat2

values = (b'elso', 74, True)
packer = struct.Struct('16s i ?')
packed_data = packer.pack(*values)

print(packed_data)

#

values = (77.5, False, b'X')
packer = struct.Struct('f ? c')
packed_data = packer.pack(*values)

print(packed_data)

#

values = (65, b'masodik', 84.9)
packer = struct.Struct('i 14s f')
packed_data = packer.pack(*values)

print(packed_data)

#

values = (b'Z', 96, b'harmadik')
packer = struct.Struct('c i 17s')
packed_data = packer.pack(*values)

print(packed_data)
