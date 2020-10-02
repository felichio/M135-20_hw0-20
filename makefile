CC = g++

myhw0: myhw0.o
	@echo Linking
	$(CC) -o myhw0 myhw0.o

myhw0.o: myhw0.cpp
	@echo Compiling
	$(CC) -c myhw0.cpp

clean:
	$(RM) myhw0.o myhw0
