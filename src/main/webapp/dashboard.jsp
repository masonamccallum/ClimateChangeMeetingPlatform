<%-- 
    Document   : dashboard
    Created on : Nov 17, 2019, 5:17:44 PM
    Author     : Johnny
--%>

<%@page import="edu.tarleton.edu.rho.climatemeetingplatform.AppChannel"%>
<%@page import="java.util.List"%>
<%@page import="edu.tarleton.edu.rho.climatemeetingplatform.AppChannelManager"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="edu.tarleton.edu.rho.climatemeetingplatform.AppUser"%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Dashboard</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@beta/dist/js.cookie.min.js"></script>
<script type='text/javascript' src='channels_js.js'></script>
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <span class="w3-bar-item w3-right">Logo</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="images/man0.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8 w3-bar">
      <span>Welcome, <strong>${user.username}</strong></span>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-tv fa-fw"></i> Your Channels</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-tv fa-fw"></i> Subscribed Channels</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-folder fa-fw"></i> Your Resources</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Settings</a><br><br>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-tv"></i> Your Channels</b></h5>
  </header>

  
  <!-- Main -->
  <div id="channel-grid-panel" class="w3-panel" >
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-threequarter">
        <div id="your-channels-header"></div>
      </div>
    </div>
  </div>
  
  <div
  
  <div id="create-channel-panel" class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-threequarter">
            <button class="w3-btn w3-large" onclick="showChannelGrid()"><i class="fa fa-arrow-left"></i> Back</button>
            <h5 id="your-channels-header">Create a Channel</h5>
            <div class="w3-container w3-half w3-margin-top">
                <label>Channel Thumbnail</label><br><br>
                <img id="preview" src="" width="426" height="240"  alt="Thumbnail preview..."><br>
                <input type="file" onchange="previewFile()">
            </div>
            <div class="w3-container w3-half w3-margin-top">

                <form id="create-channel-form" action="CreateChannel" method="post" class="w3-container">
                <p>
                <label>Channel Name</label>
                <input class="w3-input w3-border" type="text" name="channel_name" required>
                </p>
                
                <p>
                <label>Channel Description</label>
                <textarea id="channel-desc-input" name="channel_desc" class="w3-input w3-border" style="resize:none"></textarea>
                </p>
                
                <p>
                <button class="w3-button w3-section w3-teal w3-ripple"> Create </button></p>

                </form>

                </div>

      </div>
    </div>
  </div>
      
    <div id="show-channel-panel" class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
    <button class="w3-btn w3-large" onclick="showChannelGrid()"><i class="fa fa-arrow-left"></i> Back</button>
      <div class="w3-container">
            <div class="w3-container w3-quarter w3-margin-top">
                <h2 id="your-channels-header">Channel Details</h2>
                <form id="create-channel-form" action="UpdateChannel" method="post" class="w3-container">
                <p>
                <label>Channel Name</label>
                <input id="channel-details-name" class="w3-input w3-border" type="text" name="channel_name" required>
                </p>
                
                <p>
                <label>Channel Description</label>
                <textarea id="channel-details-desc" name="channel_desc" class="w3-input w3-border" style="resize:none"></textarea>
                </p>
                
                <input id="channel-details-id" type="text" name="channel_id" hidden/>
                <p>
                <button class="w3-button w3-section w3-teal w3-ripple"> Update </button></p>

                </form>

            </div>
            <div class="w3-container w3-threequarter w3-margin-top">
                <h2>Meetings</h2>
                
                <div class="w3-bar w3-black">
                  <button class="w3-bar-item w3-button tablink w3-red" onclick="openTab(event,'upcoming-meetings')">Upcoming Meetings</button>
                  <button class="w3-bar-item w3-button tablink" onclick="openTab(event,'schedule-meeting')">Schedule Meeting</button>
                  <button class="w3-bar-item w3-button tablink" onclick="openTab(event,'meeting-history')">Meeting History</button>
                </div>

                <div id="upcoming-meetings" class="w3-container w3-border tab">
                  <p>In this tab, you'll be able to see all upcoming meetings for this channel.</p>
                </div>

                <div id="schedule-meeting" class="w3-container w3-border tab" style="display:none">
                  <p>You'll schedule new meetings in this tab.</p> 
                </div>

                <div id="meeting-history" class="w3-container w3-border tab" style="display:none">
                  <p>Here, you can see the meeting history for this channel.</p>
                </div>
              </div>

      </div>
    </div>
  </div>
  <hr>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <!-- Footer -->
  <footer class="w3-container w3-padding-16 w3-light-grey w3-cell-bottom">
    <h4>FOOTER</h4>
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    <div>Avatar icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
  </footer>

  <!-- End page content -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>
