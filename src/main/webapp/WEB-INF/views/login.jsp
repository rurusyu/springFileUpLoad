<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="includes/header.jsp"  %>
 <h1>LOGIN PAGE</h1>
 
 <div class="panel panel-default">
  <div class="panel-heading">Panel heading without title</div>
  <div class="panel-body">
    Panel content
    <form method ="post">
  <div class="form-group">
    <label for="exampleInputEmail1">UID</label>
    <input type="text" class="form-control" name="uid" value="u1">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">UPW</label>
    <input type="password" class="form-control" name="upw" value="u1">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
  </div>
</div>