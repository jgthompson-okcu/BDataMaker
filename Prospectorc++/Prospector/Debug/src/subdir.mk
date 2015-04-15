################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Includes.cpp \
../src/MyClass.cpp \
../src/Patch.cpp \
../src/Prospect.cpp \
../src/Tokenize.cpp \
../src/test.cpp 

OBJS += \
./src/Includes.o \
./src/MyClass.o \
./src/Patch.o \
./src/Prospect.o \
./src/Tokenize.o \
./src/test.o 

CPP_DEPS += \
./src/Includes.d \
./src/MyClass.d \
./src/Patch.d \
./src/Prospect.d \
./src/Tokenize.d \
./src/test.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -std=c++11 -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


