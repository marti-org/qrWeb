<?php

namespace App\Presenters;

use Nette,
    App\Model,
    Nette\Application\UI\Form;


/**
 * Homepage presenter.
 */
class ProductPresenter extends BasePresenter
{
    /** @var Nette\Database\Context */
    private $database;

    public function __construct(Nette\Database\Context $database)
    {
        $this->database = $database;
    }

    public function renderShow($productId)
    {
        //$this->template->products = $this->database->table('products');
        $product = $this->database->table('products')->get($productId);
        if (!$product) {
            $this->error('Stránka nebyla nalezena');
        }
        $this->template->product = $product;
        $this->template->stars = (($product->plus-$product->minus)/($product->plus+$product->minus))*5;

        $this->template->experiences = $product->related('experience')->order('created_at');
    }

    protected function createComponentExperienceForm()
    {
        $form = new Form;

        $form->addText('user', 'User name:')
            ->setRequired();


        $form->addTextArea('text', 'Comment:')
            ->setRequired();

        $form->addSubmit('send', 'Send comment');

        $form->onSuccess[] = array($this, 'experienceFormSucceeded');

        return $form;
    }

    public function experienceFormSucceeded($form,$values)
    {
        $productId = $this->getParameter('productId');

        $this->database->table('experiences')->insert(array(
            'products_id' => $productId,
            'user'=>$values->user,
            'text'=>$values->text,
        ));

        $this->flashMessage("Saved");
        $this->redirect('this');
    }

}