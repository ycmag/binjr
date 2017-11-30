---
title: foo
layout: default
---

<link rel="stylesheet" href="binjr_files/photo.css"> 
<script src="binjr_files/photo.js"></script> 

## Lorem ipsum dolor sit amet

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

<div id="PhotoGallery" class="photo-gallery">
  <figure class="photo-gallery--image">
    <a href="../images/screenshot01.png" class="photo" title="Image 1 Description">
      <img src="../images/screenshot01.png" alt="Image 1" title="Image 1 Description">
    </a>
  </figure>
  <figure class="photo-gallery--image">
    <a href="../images/screenshot02.png" class="photo" title="Image 2 Description">
      <img  src="../images/screenshot02.png" alt="Image 2" title="Image 2 Description">
    </a>
  </figure> 
  <figure class="photo-gallery--image">
    <a href="binjr_files/screenshot03.png" class="photo" title="Image 2 Description">
      <img  src="../images/screenshot03.png" alt="Image 2" title="Image 2 Description">
    </a>
  </figure> 
  <figure class="photo-gallery--image">
    <a href="../images/screenshot04.png" class="photo" title="Image 2 Description">
      <img  src="../images/screenshot04.png" alt="Image 2" title="Image 2 Description">
    </a>
  </figure> 
</div>

## Dolore magna aliqua

Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 


<!-- Include this on pages you want the gallery to appear -->
<div id="PhotoViewer" class="photo-viewer">
  <header class="photo-viewer--title">
    <h1 id="PhotoViewerTitle">Image Title</h1>
    <div id="PhotoViewerClose" class="photo-viewer--close"><a href="#">X</a></div>
  </header>
  <div class="photo-viewer--container">
    <figure class="photo-viewer--current-image" id="PhotoViewerCurrentImageContainer">
      <img id="PhotoViewerCurrentImage" src="">
    </figure>
  </div>
  <div class="photo-viewer--controls">
      <div id="PhotoViewerPreviousImage" class="photo-viewer--previous-image"><a href="#">&laquo; Previous</a></div>
      <div id="PhotoViewerCount" class="photo-viewer--count">1/10</div>
      <div id="PhotoViewerNextImage" class="photo-viewer--next-image"><a href="#">Next &raquo;</a></div>
    </div>
</div>