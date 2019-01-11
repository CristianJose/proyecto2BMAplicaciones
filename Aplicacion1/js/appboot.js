$(window).scroll(function() {
  if ($("#menu").offset().top > 56) {
      $("#menu").addClass("nav-celeste");
      $("#menu").removeClass("bg-transparent");
  }
  
  if ($("#menu").offset().top < 56) {
      $("#menu").addClass("bg-transparent");
      $("#menu").removeClass("nav-celeste");
  }
});


document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener('click', function (e) {
    e.preventDefault();

    document.querySelector(this.getAttribute('href')).scrollIntoView({
        behavior: 'smooth'
    });
  });
});