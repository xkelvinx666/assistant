package cn.caijinbiao.assistant.response;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private String excelNotFound;
    private String excelException;
    private String paramNotComplete;
    private String examInfoNotFound;
    private String supervisorNotMatch;
    private String examNotMatchStudent;
    private String examInfoHasFound;
    private String roomNameIsNull;
    private String roomNotFound;
    private String cantSeatInfo;
    private String isNotFilled;
    private String beforeLegalShowTime;
    private String courseNotMatchNow;
    private String unknownException;
    private String timeIsNull;
    private String roomNotMatchNow;
    private String succeedSetSeat;
    private String errorInSetSeat;

    public Message() {
    }

    public Message(String excelNotFound, String excelException, String paramNotComplete, String examInfoNotFound, String supervisorNotMatch, String examNotMatchStudent, String examInfoHasFound, String roomNameIsNull, String roomNotFound, String cantSeatInfo, String isNotFilled, String beforeLegalShowTime, String courseNotMatchNow, String unknownException, String timeIsNull, String roomNotMatchNow, String succeedSetSeat, String errorInSetSeat) {
        this.excelNotFound = excelNotFound;
        this.excelException = excelException;
        this.paramNotComplete = paramNotComplete;
        this.examInfoNotFound = examInfoNotFound;
        this.supervisorNotMatch = supervisorNotMatch;
        this.examNotMatchStudent = examNotMatchStudent;
        this.examInfoHasFound = examInfoHasFound;
        this.roomNameIsNull = roomNameIsNull;
        this.roomNotFound = roomNotFound;
        this.cantSeatInfo = cantSeatInfo;
        this.isNotFilled = isNotFilled;
        this.beforeLegalShowTime = beforeLegalShowTime;
        this.courseNotMatchNow = courseNotMatchNow;
        this.unknownException = unknownException;
        this.timeIsNull = timeIsNull;
        this.roomNotMatchNow = roomNotMatchNow;
        this.succeedSetSeat = succeedSetSeat;
        this.errorInSetSeat = errorInSetSeat;
    }

    public String getExcelNotFound() {
        return excelNotFound;
    }

    public void setExcelNotFound(String excelNotFound) {
        this.excelNotFound = excelNotFound;
    }

    public String getExcelException() {
        return excelException;
    }

    public void setExcelException(String excelException) {
        this.excelException = excelException;
    }

    public String getParamNotComplete() {
        return paramNotComplete;
    }

    public void setParamNotComplete(String paramNotComplete) {
        this.paramNotComplete = paramNotComplete;
    }

    public String getExamInfoNotFound() {
        return examInfoNotFound;
    }

    public void setExamInfoNotFound(String examInfoNotFound) {
        this.examInfoNotFound = examInfoNotFound;
    }

    public String getSupervisorNotMatch() {
        return supervisorNotMatch;
    }

    public void setSupervisorNotMatch(String supervisorNotMatch) {
        this.supervisorNotMatch = supervisorNotMatch;
    }

    public String getExamNotMatchStudent() {
        return examNotMatchStudent;
    }

    public void setExamNotMatchStudent(String examNotMatchStudent) {
        this.examNotMatchStudent = examNotMatchStudent;
    }

    public String getExamInfoHasFound() {
        return examInfoHasFound;
    }

    public void setExamInfoHasFound(String examInfoHasFound) {
        this.examInfoHasFound = examInfoHasFound;
    }

    public String getRoomNameIsNull() {
        return roomNameIsNull;
    }

    public void setRoomNameIsNull(String roomNameIsNull) {
        this.roomNameIsNull = roomNameIsNull;
    }

    public String getRoomNotFound() {
        return roomNotFound;
    }

    public void setRoomNotFound(String roomNotFound) {
        this.roomNotFound = roomNotFound;
    }

    public String getCantSeatInfo() {
        return cantSeatInfo;
    }

    public void setCantSeatInfo(String cantSeatInfo) {
        this.cantSeatInfo = cantSeatInfo;
    }

    public String getIsNotFilled() {
        return isNotFilled;
    }

    public void setIsNotFilled(String isNotFilled) {
        this.isNotFilled = isNotFilled;
    }

    public String getBeforeLegalShowTime() {
        return beforeLegalShowTime;
    }

    public void setBeforeLegalShowTime(String beforeLegalShowTime) {
        this.beforeLegalShowTime = beforeLegalShowTime;
    }

    public String getCourseNotMatchNow() {
        return courseNotMatchNow;
    }

    public void setCourseNotMatchNow(String courseNotMatchNow) {
        this.courseNotMatchNow = courseNotMatchNow;
    }

    public String getUnknownException() {
        return unknownException;
    }

    public void setUnknownException(String unknownException) {
        this.unknownException = unknownException;
    }

    public String getTimeIsNull() {
        return timeIsNull;
    }

    public void setTimeIsNull(String timeIsNull) {
        this.timeIsNull = timeIsNull;
    }

    public String getRoomNotMatchNow() {
        return roomNotMatchNow;
    }

    public void setRoomNotMatchNow(String roomNotMatchNow) {
        this.roomNotMatchNow = roomNotMatchNow;
    }

    public String getSucceedSetSeat() {
        return succeedSetSeat;
    }

    public void setSucceedSetSeat(String succeedSetSeat) {
        this.succeedSetSeat = succeedSetSeat;
    }

    public String getErrorInSetSeat() {
        return errorInSetSeat;
    }

    public void setErrorInSetSeat(String errorInSetSeat) {
        this.errorInSetSeat = errorInSetSeat;
    }
}
