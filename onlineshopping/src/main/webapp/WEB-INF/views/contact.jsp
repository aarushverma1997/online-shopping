


<section class="jumbotron text-center">
    <div class="container">
    
        <h1 class="jumbotron-heading">Contact Us</h1>
        <p class="lead text-muted mb-0">Contact us We replay soon !</p>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    
                    <li class="breadcrumb-item active" aria-current="page">Contact</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
   <c:if test="${not empty message }">
   
   <div class="col-xs-12 col-lg-12">

				<div class="alert alert-success alart-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
   
   
   </c:if>


    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> Contact us.
                </div>
                <div class="card-body">
                    <form id="contactForm" action="emailSend" method="POST">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" name="name" id="name" aria-describedby="emailHelp" placeholder="Enter name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Enter email" required>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="message">Message</label>
                            <textarea class="form-control" name="message" id="message" rows="6" required></textarea>
                        </div>
                        <div class="mx-auto">
                        <button type="submit" class="btn btn-primary text-right">Submit</button></div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-4">
        <div class="row">
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i> Address</div>
                <div class="card-body">
                    <p>512 Gram sundrel</p>
                    <p>Dist : Dhar &nbsp; Teh. : dharmpuri</p>
                    <p>state : MadhyaPradesh  &nbsp; postal code : 454552 </p>
                    <p></p>
                    <p>Email : ravindraverma97@gmail.com</p>
                    <p>Mobile. +91 939 96 93 093 </p>

                </div>

            </div>
            </div>
            <div class="row">
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i>Office Address</div>
                <div class="card-body">
                    <p>Nx  VishnuPuri Indore</p>
                    <p>Dist : indore &nbsp; Teh. : indorw</p>
                    <p>state : MadhyaPradesh  &nbsp; postal code : 455002 </p>
                    <p></p>
                    <p>Email : black_codder@gmail.com</p>
                    <p>Mobile. soon </p>

                </div>

            </div>
            </div>
        </div>
    </div>
</div>