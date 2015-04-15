#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=gfortran
AS=as

# Macros
CND_PLATFORM=Cygwin_4.x-Windows
CND_DLIB_EXT=dll
CND_CONF=Debug
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/_ext/1946407073/Includes.o \
	${OBJECTDIR}/_ext/1946407073/Main.cpp.o \
	${OBJECTDIR}/_ext/1946407073/MyClass.o \
	${OBJECTDIR}/_ext/1946407073/Prospect.o \
	${OBJECTDIR}/_ext/1946407073/Tokenize.o


# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/bprospector.exe

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/bprospector.exe: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	${LINK.cc} -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/bprospector ${OBJECTFILES} ${LDLIBSOPTIONS}

${OBJECTDIR}/_ext/1946407073/Includes.o: ../../Prospectorc++/Prospector/src/Includes.cpp 
	${MKDIR} -p ${OBJECTDIR}/_ext/1946407073
	${RM} "$@.d"
	$(COMPILE.cc) -g -std=c++11 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/1946407073/Includes.o ../../Prospectorc++/Prospector/src/Includes.cpp

${OBJECTDIR}/_ext/1946407073/Main.cpp.o: ../../Prospectorc++/Prospector/src/Main.cpp.cpp 
	${MKDIR} -p ${OBJECTDIR}/_ext/1946407073
	${RM} "$@.d"
	$(COMPILE.cc) -g -std=c++11 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/1946407073/Main.cpp.o ../../Prospectorc++/Prospector/src/Main.cpp.cpp

${OBJECTDIR}/_ext/1946407073/MyClass.o: ../../Prospectorc++/Prospector/src/MyClass.cpp 
	${MKDIR} -p ${OBJECTDIR}/_ext/1946407073
	${RM} "$@.d"
	$(COMPILE.cc) -g -std=c++11 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/1946407073/MyClass.o ../../Prospectorc++/Prospector/src/MyClass.cpp

${OBJECTDIR}/_ext/1946407073/Prospect.o: ../../Prospectorc++/Prospector/src/Prospect.cpp 
	${MKDIR} -p ${OBJECTDIR}/_ext/1946407073
	${RM} "$@.d"
	$(COMPILE.cc) -g -std=c++11 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/1946407073/Prospect.o ../../Prospectorc++/Prospector/src/Prospect.cpp

${OBJECTDIR}/_ext/1946407073/Tokenize.o: ../../Prospectorc++/Prospector/src/Tokenize.cpp 
	${MKDIR} -p ${OBJECTDIR}/_ext/1946407073
	${RM} "$@.d"
	$(COMPILE.cc) -g -std=c++11 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/_ext/1946407073/Tokenize.o ../../Prospectorc++/Prospector/src/Tokenize.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}
	${RM} ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/bprospector.exe

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
